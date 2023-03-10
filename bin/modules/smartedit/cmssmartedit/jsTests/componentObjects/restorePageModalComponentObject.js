/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
var genericEditor, genericEditorWidgets;
if (typeof require !== 'undefined') {
    genericEditor = require('./genericEditorComponentObject');
    genericEditorWidgets = require('./genericEditorWidgetsComponentObject');
}

module.exports = (function() {
    var componentObject = {};

    componentObject.constants = {
        RESTORE_ERROR_TYPES: {
            DUPLICATED_NAME: 'DUPLICATED_NAME',
            DUPLICATE_CONTENT_PRIMARY_PAGE: 'DUPLICATE_CONTENT_PRIMARY_PAGE',
            MISSING_CONTENT_PRIMARY_PAGE: 'MISSING_CONTENT_PRIMARY_PAGE',
            DUPLICATE_NON_CONTENT_PRIMARY_PAGE: 'DUPLICATE_NON_CONTENT_PRIMARY_PAGE',
            MISSING_NON_CONTENT_PRIMARY_PAGE: 'MISSING_NON_CONTENT_PRIMARY_PAGE'
        },
        RESOLUTION_OPTIONS: {
            OVERWRITE_PAGE: 'overwritePrimaryPageOption',
            RENAME_LABEL: 'renamePrimaryPageOption'
        }
    };

    componentObject.elements = {
        // -- Alerts --
        getPageRestoredAlert: function() {
            return element(by.css('fd-alert.fd-alert--success'));
        },

        // -- Content Pages --
        getDuplicateContentPrimaryPageResolutionOption: function(resolutionOptionId) {
            return element(by.css('label[for=' + resolutionOptionId + ']'));
        },
        getPrimaryContentPageSelector: function() {
            return element(
                by.css('y-select[data-id=se-page-restore-change-primary-selector-dropdown]')
            );
        },
        getPrimaryContentPageSelectorOpenButton: function() {
            return this.getPrimaryContentPageSelector().element(by.css('.ui-select-toggle'));
        },
        getPrimaryContentPageSelectorOption: function(pageName) {
            var element = this.getPrimaryContentPageSelector().element(
                by.cssContainingText('.ui-select-choices li[role=option] span', pageName)
            );
            browser.waitForPresence(element);
            return element;
        }
    };

    componentObject.actions = {
        // -- Modal ---
        saveChanges: function() {
            return genericEditor.actions.save();
        },
        cancelChanges: function() {
            return genericEditor.actions.cancel();
        },

        // -- All pages --
        setName: function(newName) {
            return genericEditorWidgets.actions.setTextFieldValue('name', newName);
        },

        // -- Content Page --
        setDuplicateContentPrimaryPageResolution: function(resolutionToUse) {
            browser.waitForPresence(
                componentObject.elements.getDuplicateContentPrimaryPageResolutionOption(
                    resolutionToUse
                )
            );
            return browser.click(
                componentObject.elements.getDuplicateContentPrimaryPageResolutionOption(
                    resolutionToUse
                )
            );
        },
        changePrimaryPageLabel: function(newLabel) {
            return this.setDuplicateContentPrimaryPageResolution(
                componentObject.constants.RESOLUTION_OPTIONS.RENAME_LABEL
            ).then(function() {
                return genericEditorWidgets.actions.setTextFieldValue('label', newLabel);
            });
        },
        openPrimaryPageSelector: function() {
            return browser.click(
                componentObject.elements.getPrimaryContentPageSelectorOpenButton()
            );
        },
        selectNewPrimaryContentPage: function(primaryPageToSelect) {
            return this.openPrimaryPageSelector().then(function() {
                return browser.click(
                    componentObject.elements.getPrimaryContentPageSelectorOption(
                        primaryPageToSelect
                    )
                );
            });
        }
    };

    componentObject.assertions = {
        successAlertIsDisplayed: function() {
            browser.waitToBeDisplayed(componentObject.elements.getPageRestoredAlert());
        },
        successAlertIsNotDisplayed: function() {
            expect(componentObject.elements.getPageRestoredAlert()).toBeAbsent();
        }
    };

    componentObject.utils = {};

    return componentObject;
})();
