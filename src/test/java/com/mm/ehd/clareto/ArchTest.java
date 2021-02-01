package com.mm.ehd.clareto;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.mm.ehd.clareto");

        noClasses()
            .that()
            .resideInAnyPackage("com.mm.ehd.clareto.service..")
            .or()
            .resideInAnyPackage("com.mm.ehd.clareto.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.mm.ehd.clareto.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
