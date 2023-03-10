/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
export class FunctionsUtilsHelper {
    isBlank() {
        const spy = jasmine.createSpy('isBlank');
        spy.and.callFake(function(value: string) {
            return (
                typeof value === 'undefined' ||
                value === null ||
                value === 'null' ||
                value.toString().trim().length === 0
            );
        });
        return spy;
    }
}

export const functionsUtilsHelper = new FunctionsUtilsHelper();
