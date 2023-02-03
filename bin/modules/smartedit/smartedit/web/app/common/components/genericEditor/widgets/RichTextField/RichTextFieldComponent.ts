/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { AfterViewInit, Component, ElementRef, Inject, OnDestroy, ViewChild } from '@angular/core';
import { TypedMap } from '@smart/utils';

import { SeDowngradeComponent } from 'smarteditcommons/di';
import { GenericEditorSanitizationService } from './services/GenericEditorSanitizationService';
import { GenericEditorWidgetData } from '../../../genericEditor/types';
import { RichTextLoaderService } from './services/RichTextLoaderService';
import { RICH_TEXT_CONFIGURATION } from './tokens';
import { RichTextFieldLocalizationService } from './services/RichTextFieldLocalizationService';
import { GENERIC_EDITOR_WIDGET_DATA } from '../../components/GenericEditorFieldComponent';

/* @internal */
@SeDowngradeComponent()
@Component({
    selector: 'se-rich-text-field',
    templateUrl: './RichTextFieldComponent.html'
})
export class RichTextFieldComponent implements AfterViewInit, OnDestroy {
    @ViewChild('textarea', { static: false }) private textarea: ElementRef;

    private mode: string;
    private editorInstance: CKEDITOR.editor;

    constructor(
        @Inject(GENERIC_EDITOR_WIDGET_DATA) public widget: GenericEditorWidgetData<any>,
        private seRichTextLoaderService: RichTextLoaderService,
        @Inject(RICH_TEXT_CONFIGURATION) private seRichTextConfiguration: TypedMap<any>,
        private genericEditorSanitizationService: GenericEditorSanitizationService,
        private seRichTextFieldLocalizationService: RichTextFieldLocalizationService
    ) {}

    ngAfterViewInit(): Promise<void> {
        return this.seRichTextLoaderService.load().then(() => {
            this.editorInstance = CKEDITOR.replace(
                this.textarea.nativeElement,
                this.seRichTextConfiguration
            );

            this.seRichTextFieldLocalizationService.localizeCKEditor();

            if (this.editorInstance) {
                this.editorInstance.on('change', () => this.onChange());
                this.editorInstance.on('mode', () => this.onMode());
                CKEDITOR.on('instanceReady', (ev: any) => this.onInstanceReady(ev));
            }
        });
    }

    ngOnDestroy(): void {
        if (this.editorInstance && CKEDITOR.instances[this.editorInstance.name]) {
            this.editorInstance.removeAllListeners();
            CKEDITOR.removeAllListeners();
            CKEDITOR.instances[this.editorInstance.name].destroy();
        }
    }

    onChange(): void {
        setTimeout(() => {
            this.widget.model[this.widget.qualifier] = this.editorInstance.getData();
            this.reassignUserCheck();
        });
    }

    onMode(): void {
        if (this.mode === 'source') {
            const editable = this.editorInstance.editable();
            editable.attachListener(editable, 'input', () => {
                this.editorInstance.fire('change');
            });
        }
    }

    onInstanceReady(ev: any): void {
        ev.editor.dataProcessor.writer.setRules('br', {
            indent: false,
            breakBeforeOpen: false,
            breakAfterOpen: false,
            breakBeforeClose: false,
            breakAfterClose: false
        });
    }

    requiresUserCheck(): boolean {
        let requiresUserCheck = false;
        for (const qualifier in this.widget.field.requiresUserCheck) {
            if (this.widget.field.requiresUserCheck.hasOwnProperty(qualifier)) {
                requiresUserCheck =
                    requiresUserCheck || this.widget.field.requiresUserCheck[qualifier];
            }
        }
        return requiresUserCheck;
    }

    reassignUserCheck(): void {
        if (
            this.widget.model &&
            this.widget.qualifier &&
            this.widget.model[this.widget.qualifier]
        ) {
            const sanitizedContentMatchesContent = this.genericEditorSanitizationService.isSanitized(
                this.widget.model[this.widget.qualifier]
            );
            this.widget.field.requiresUserCheck = this.widget.field.requiresUserCheck || {};
            this.widget.field.requiresUserCheck[
                this.widget.qualifier
            ] = !sanitizedContentMatchesContent;
        } else {
            this.widget.field.requiresUserCheck = this.widget.field.requiresUserCheck || {};
            this.widget.field.requiresUserCheck[this.widget.qualifier] = false;
        }
    }
}
