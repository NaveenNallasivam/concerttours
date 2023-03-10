(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["angularStorefront"],{

/***/ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/tslib/tslib.es6.js":
/*!********************************************************************************************************************************************************!*\
  !*** /var/lib/jenkins/workspace/generic-build-product/sources/modules/npm-ancillary-module/npmancillary/resources/npm/node_modules/tslib/tslib.es6.js ***!
  \********************************************************************************************************************************************************/
/*! exports provided: __extends, __assign, __rest, __decorate, __param, __metadata, __awaiter, __generator, __exportStar, __values, __read, __spread, __await, __asyncGenerator, __asyncDelegator, __asyncValues, __makeTemplateObject, __importStar, __importDefault */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__extends", function() { return __extends; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__assign", function() { return __assign; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__rest", function() { return __rest; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__decorate", function() { return __decorate; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__param", function() { return __param; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__metadata", function() { return __metadata; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__awaiter", function() { return __awaiter; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__generator", function() { return __generator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__exportStar", function() { return __exportStar; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__values", function() { return __values; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__read", function() { return __read; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__spread", function() { return __spread; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__await", function() { return __await; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncGenerator", function() { return __asyncGenerator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncDelegator", function() { return __asyncDelegator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncValues", function() { return __asyncValues; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__makeTemplateObject", function() { return __makeTemplateObject; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__importStar", function() { return __importStar; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__importDefault", function() { return __importDefault; });
/*! *****************************************************************************
Copyright (c) Microsoft Corporation. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at http://www.apache.org/licenses/LICENSE-2.0

THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
MERCHANTABLITY OR NON-INFRINGEMENT.

See the Apache Version 2.0 License for specific language governing permissions
and limitations under the License.
***************************************************************************** */
/* global Reflect, Promise */

var extendStatics = function(d, b) {
    extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return extendStatics(d, b);
};

function __extends(d, b) {
    extendStatics(d, b);
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
}

var __assign = function() {
    __assign = Object.assign || function __assign(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p)) t[p] = s[p];
        }
        return t;
    }
    return __assign.apply(this, arguments);
}

function __rest(s, e) {
    var t = {};
    for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p) && e.indexOf(p) < 0)
        t[p] = s[p];
    if (s != null && typeof Object.getOwnPropertySymbols === "function")
        for (var i = 0, p = Object.getOwnPropertySymbols(s); i < p.length; i++) if (e.indexOf(p[i]) < 0)
            t[p[i]] = s[p[i]];
    return t;
}

function __decorate(decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
}

function __param(paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
}

function __metadata(metadataKey, metadataValue) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(metadataKey, metadataValue);
}

function __awaiter(thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
}

function __generator(thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
}

function __exportStar(m, exports) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}

function __values(o) {
    var m = typeof Symbol === "function" && o[Symbol.iterator], i = 0;
    if (m) return m.call(o);
    return {
        next: function () {
            if (o && i >= o.length) o = void 0;
            return { value: o && o[i++], done: !o };
        }
    };
}

function __read(o, n) {
    var m = typeof Symbol === "function" && o[Symbol.iterator];
    if (!m) return o;
    var i = m.call(o), r, ar = [], e;
    try {
        while ((n === void 0 || n-- > 0) && !(r = i.next()).done) ar.push(r.value);
    }
    catch (error) { e = { error: error }; }
    finally {
        try {
            if (r && !r.done && (m = i["return"])) m.call(i);
        }
        finally { if (e) throw e.error; }
    }
    return ar;
}

function __spread() {
    for (var ar = [], i = 0; i < arguments.length; i++)
        ar = ar.concat(__read(arguments[i]));
    return ar;
}

function __await(v) {
    return this instanceof __await ? (this.v = v, this) : new __await(v);
}

function __asyncGenerator(thisArg, _arguments, generator) {
    if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
    var g = generator.apply(thisArg, _arguments || []), i, q = [];
    return i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i;
    function verb(n) { if (g[n]) i[n] = function (v) { return new Promise(function (a, b) { q.push([n, v, a, b]) > 1 || resume(n, v); }); }; }
    function resume(n, v) { try { step(g[n](v)); } catch (e) { settle(q[0][3], e); } }
    function step(r) { r.value instanceof __await ? Promise.resolve(r.value.v).then(fulfill, reject) : settle(q[0][2], r); }
    function fulfill(value) { resume("next", value); }
    function reject(value) { resume("throw", value); }
    function settle(f, v) { if (f(v), q.shift(), q.length) resume(q[0][0], q[0][1]); }
}

function __asyncDelegator(o) {
    var i, p;
    return i = {}, verb("next"), verb("throw", function (e) { throw e; }), verb("return"), i[Symbol.iterator] = function () { return this; }, i;
    function verb(n, f) { i[n] = o[n] ? function (v) { return (p = !p) ? { value: __await(o[n](v)), done: n === "return" } : f ? f(v) : v; } : f; }
}

function __asyncValues(o) {
    if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
    var m = o[Symbol.asyncIterator], i;
    return m ? m.call(o) : (o = typeof __values === "function" ? __values(o) : o[Symbol.iterator](), i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i);
    function verb(n) { i[n] = o[n] && function (v) { return new Promise(function (resolve, reject) { v = o[n](v), settle(resolve, reject, v.done, v.value); }); }; }
    function settle(resolve, reject, d, v) { Promise.resolve(v).then(function(v) { resolve({ value: v, done: d }); }, reject); }
}

function __makeTemplateObject(cooked, raw) {
    if (Object.defineProperty) { Object.defineProperty(cooked, "raw", { value: raw }); } else { cooked.raw = raw; }
    return cooked;
};

function __importStar(mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result.default = mod;
    return result;
}

function __importDefault(mod) {
    return (mod && mod.__esModule) ? mod : { default: mod };
}


/***/ }),

/***/ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/webpack/buildin/global.js":
/*!***********************************!*\
  !*** (webpack)/buildin/global.js ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

var g;

// This works in non-strict mode
g = (function() {
	return this;
})();

try {
	// This works if eval is allowed (see CSP)
	g = g || new Function("return this")();
} catch (e) {
	// This works if the window reference is available
	if (typeof window === "object") g = window;
}

// g can still be undefined, but nothing to do about it...
// We return undefined, instead of nothing here, so it's
// easier to handle this case. if(!global) { ...}

module.exports = g;


/***/ }),

/***/ "./smartedit-build/test/e2e/dummystorefront/angular/AppComponent.ts":
/*!**************************************************************************!*\
  !*** ./smartedit-build/test/e2e/dummystorefront/angular/AppComponent.ts ***!
  \**************************************************************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/core/fesm5/core.js");

/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */

var AppComponent = /** @class */ (function () {
    function AppComponent() {
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'storefront-app',
            template: "\n        <span>this is the root of the Angular storefront</span> <br />\n        <a [routerLink]=\"['/page1']\">page1</a> <br />\n        <a [routerLink]=\"['/page2']\">page2</a>\n        <router-outlet></router-outlet>\n    "
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./smartedit-build/test/e2e/dummystorefront/angular/Page1Component.ts":
/*!****************************************************************************!*\
  !*** ./smartedit-build/test/e2e/dummystorefront/angular/Page1Component.ts ***!
  \****************************************************************************/
/*! exports provided: Page1Component */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page1Component", function() { return Page1Component; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/core/fesm5/core.js");

/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */

var Page1Component = /** @class */ (function () {
    function Page1Component() {
    }
    Page1Component = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'page1',
            template: "\n        <div\n            class=\"slot smartEditComponent\"\n            id=\"staticDummySlot\"\n            data-smartedit-component-type=\"ContentSlot\"\n            data-smartedit-component-id=\"staticDummySlot\"\n            data-smartedit-catalog-version-uuid=\"apparel-ukContentCatalog/Staged\"\n            data-smartedit-component-uuid=\"staticDummySlot\"\n        >\n            <div\n                class=\"component smartEditComponent\"\n                id=\"staticDummyComponent\"\n                data-smartedit-component-type=\"componentType1\"\n                data-smartedit-component-id=\"staticDummyComponent\"\n                data-smartedit-component-uuid=\"staticDummyComponent\"\n                data-smartedit-catalog-version-uuid=\"apparel-ukContentCatalog/Staged\"\n            >\n                <div class=\"box\"><p>new component 1</p></div>\n            </div>\n        </div>\n    "
        })
    ], Page1Component);
    return Page1Component;
}());



/***/ }),

/***/ "./smartedit-build/test/e2e/dummystorefront/angular/Page2Component.ts":
/*!****************************************************************************!*\
  !*** ./smartedit-build/test/e2e/dummystorefront/angular/Page2Component.ts ***!
  \****************************************************************************/
/*! exports provided: Page2Component */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Page2Component", function() { return Page2Component; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/core/fesm5/core.js");

/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */

var Page2Component = /** @class */ (function () {
    function Page2Component() {
    }
    Page2Component = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'page2',
            template: "\n        <div\n            class=\"slot smartEditComponent\"\n            id=\"staticDummySlot\"\n            data-smartedit-component-type=\"ContentSlot\"\n            data-smartedit-component-id=\"staticDummySlot\"\n            data-smartedit-catalog-version-uuid=\"apparel-ukContentCatalog/Staged\"\n            data-smartedit-component-uuid=\"staticDummySlot\"\n        >\n            <div\n                class=\"component smartEditComponent\"\n                id=\"staticDummyComponent\"\n                data-smartedit-component-type=\"componentType2\"\n                data-smartedit-component-id=\"staticDummyComponent\"\n                data-smartedit-component-uuid=\"staticDummyComponent\"\n                data-smartedit-catalog-version-uuid=\"apparel-ukContentCatalog/Staged\"\n            >\n                <div class=\"box\"><p>new component 2</p></div>\n            </div>\n        </div>\n    "
        })
    ], Page2Component);
    return Page2Component;
}());



/***/ }),

/***/ "./smartedit-build/test/e2e/dummystorefront/angular/index.ts":
/*!*******************************************************************!*\
  !*** ./smartedit-build/test/e2e/dummystorefront/angular/index.ts ***!
  \*******************************************************************/
/*! exports provided: Storefront */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Storefront", function() { return Storefront; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/tslib/tslib.es6.js");
/* harmony import */ var core_js_client_shim__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! core-js/client/shim */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/core-js/client/shim.js");
/* harmony import */ var core_js_client_shim__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(core_js_client_shim__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var zone_js_dist_zone__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! zone.js/dist/zone */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/zone.js/dist/zone.js");
/* harmony import */ var zone_js_dist_zone__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(zone_js_dist_zone__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/common/fesm5/common.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/core */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/platform-browser */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "../../npm-ancillary-module/npmancillary/resources/npm/node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _Page1Component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./Page1Component */ "./smartedit-build/test/e2e/dummystorefront/angular/Page1Component.ts");
/* harmony import */ var _Page2Component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./Page2Component */ "./smartedit-build/test/e2e/dummystorefront/angular/Page2Component.ts");
/* harmony import */ var _AppComponent__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./AppComponent */ "./smartedit-build/test/e2e/dummystorefront/angular/AppComponent.ts");

/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */










var Storefront = /** @class */ (function () {
    function Storefront() {
    }
    Storefront = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_4__["NgModule"])({
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_5__["BrowserModule"],
                _angular_router__WEBPACK_IMPORTED_MODULE_7__["RouterModule"].forRoot([
                    { path: 'page1', pathMatch: 'full', component: _Page1Component__WEBPACK_IMPORTED_MODULE_8__["Page1Component"] },
                    { path: 'page2', pathMatch: 'full', component: _Page2Component__WEBPACK_IMPORTED_MODULE_9__["Page2Component"] },
                    { path: '', pathMatch: 'full', redirectTo: 'page1' }
                ], { useHash: true, initialNavigation: true })
            ],
            declarations: [_AppComponent__WEBPACK_IMPORTED_MODULE_10__["AppComponent"], _Page1Component__WEBPACK_IMPORTED_MODULE_8__["Page1Component"], _Page2Component__WEBPACK_IMPORTED_MODULE_9__["Page2Component"]],
            entryComponents: [_AppComponent__WEBPACK_IMPORTED_MODULE_10__["AppComponent"], _Page1Component__WEBPACK_IMPORTED_MODULE_8__["Page1Component"], _Page2Component__WEBPACK_IMPORTED_MODULE_9__["Page2Component"]],
            providers: [{ provide: _angular_common__WEBPACK_IMPORTED_MODULE_3__["APP_BASE_HREF"], useValue: '!' }],
            bootstrap: [_AppComponent__WEBPACK_IMPORTED_MODULE_10__["AppComponent"]]
        })
    ], Storefront);
    return Storefront;
}());

Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_6__["platformBrowserDynamic"])()
    .bootstrapModule(Storefront)
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ "./smartedit-custom-build/web/app lazy recursive":
/*!**************************************************************!*\
  !*** ./smartedit-custom-build/web/app lazy namespace object ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./smartedit-custom-build/web/app lazy recursive";

/***/ })

},[["./smartedit-build/test/e2e/dummystorefront/angular/index.ts","runtime","storefrontvendor"]]]);
//# sourceMappingURL=angularStorefront.js.map