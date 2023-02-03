/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { Component, Inject, OnInit } from '@angular/core';

import { GenericEditorWidgetData } from '../../../genericEditor/types';
import { GENERIC_EDITOR_WIDGET_DATA } from '../../components/GenericEditorFieldComponent';

/**
 * Component responsible for generating custom toggle for the Generic Editor.
 *
 * The following is an example of a possible field structures that can be returned by the Structure API for seBoolean to work:
 * {
 *   cmsStructureType: "Boolean",
 *   qualifier: "someQualifier",
 *   i18nKey: 'i18nkeyForSomeQualifier',
 *   localized: false,
 *   defaultValue: true
 * }
 *
 * There is an optional property called defaultValue (which can be set to TRUE to enable the toggle by default)
 */

@Component({
    selector: 'se-boolean',
    templateUrl: './BooleanComponent.html'
})
export class BooleanComponent implements OnInit {
    constructor(@Inject(GENERIC_EDITOR_WIDGET_DATA) public widget: GenericEditorWidgetData<any>) {}

    ngOnInit(): void {
        if (this.widget.model[this.widget.qualifier] === undefined) {
            const defaultValue =
                this.widget.field.defaultValue !== undefined
                    ? this.widget.field.defaultValue
                    : false;
            this.widget.model[this.widget.qualifier] = defaultValue;
            this.widget.editor.pristine[this.widget.qualifier] = defaultValue;
        }
    }
}
