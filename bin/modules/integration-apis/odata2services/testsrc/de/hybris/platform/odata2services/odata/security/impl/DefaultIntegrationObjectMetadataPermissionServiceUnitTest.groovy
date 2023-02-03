/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2services.odata.security.impl

import de.hybris.bootstrap.annotations.UnitTest
import de.hybris.platform.core.model.type.ComposedTypeModel
import de.hybris.platform.integrationservices.config.IntegrationServicesConfiguration
import de.hybris.platform.integrationservices.model.IntegrationObjectItemModel
import de.hybris.platform.integrationservices.model.IntegrationObjectModel
import de.hybris.platform.integrationservices.security.TypeAccessPermissionException
import de.hybris.platform.integrationservices.service.IntegrationObjectService
import de.hybris.platform.odata2services.odata.processor.ServiceNameExtractor
import de.hybris.platform.servicelayer.security.permissions.PermissionCRUDService
import org.apache.olingo.odata2.api.processor.ODataContext
import org.junit.Test
import spock.lang.Specification

@UnitTest
class DefaultIntegrationObjectMetadataPermissionServiceUnitTest extends Specification {

    private static final def ROOT_TYPE = "Product"
    private static final def INTEGRATION_OBJECT = "InboundProduct"

    def context = Stub(ODataContext)
    def permissionCRUDService = Stub(PermissionCRUDService)
    def serviceNameExtractor = Stub(ServiceNameExtractor) { extract(context) >> INTEGRATION_OBJECT }
    def integrationObjectService = Stub(IntegrationObjectService) {
        findIntegrationObject(INTEGRATION_OBJECT) >> Stub(IntegrationObjectModel) {
            getRootItem() >> Stub(IntegrationObjectItemModel) {
                getType() >> Stub(ComposedTypeModel) {
                    getCode() >> ROOT_TYPE
                }
            }
        }
    }
    def integrationServicesConfiguration = Stub(IntegrationServicesConfiguration)

    def defaultIntegrationObjectPermissionService = new DefaultIntegrationObjectMetadataPermissionService(
            permissionCRUDService,
            serviceNameExtractor,
            integrationObjectService,
            integrationServicesConfiguration)


    @Test
    def "check metadata read permission when access right check is enabled and #operation permission is granted"() {
        given:
        integrationServicesConfiguration.accessRightsEnabled >> true
        permissionCRUDService.canReadType(ROOT_TYPE) >> read
        permissionCRUDService.canCreateTypeInstance(ROOT_TYPE) >> create
        permissionCRUDService.canChangeType(ROOT_TYPE) >> change
        permissionCRUDService.canRemoveTypeInstance(ROOT_TYPE) >> remove

        when:
        defaultIntegrationObjectPermissionService.checkMetadataPermission(context)

        then:
        notThrown(TypeAccessPermissionException)

        where:
        operation | read  | create | change | remove
        'read'    | true  | false  | false  | false
        'create'  | false | true   | false  | false
        'change'  | false | false  | true   | false
        'remove'  | false | false  | false  | true
    }

    @Test
    def "check metadata read permission when access right check is enabled and permission is not granted"() {
        given:
        integrationServicesConfiguration.accessRightsEnabled >> true
        permissionCRUDService.canReadType(ROOT_TYPE) >> false
        permissionCRUDService.canCreateTypeInstance(ROOT_TYPE) >> false
        permissionCRUDService.canChangeType(ROOT_TYPE) >> false
        permissionCRUDService.canRemoveTypeInstance(ROOT_TYPE) >> false

        when:
        defaultIntegrationObjectPermissionService.checkMetadataPermission(context)

        then:
        thrown(TypeAccessPermissionException)
    }

}
