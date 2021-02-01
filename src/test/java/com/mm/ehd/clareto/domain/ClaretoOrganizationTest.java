package com.mm.ehd.clareto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mm.ehd.clareto.web.rest.TestUtil;

public class ClaretoOrganizationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClaretoOrganization.class);
        ClaretoOrganization claretoOrganization1 = new ClaretoOrganization();
        claretoOrganization1.setId(1L);
        ClaretoOrganization claretoOrganization2 = new ClaretoOrganization();
        claretoOrganization2.setId(claretoOrganization1.getId());
        assertThat(claretoOrganization1).isEqualTo(claretoOrganization2);
        claretoOrganization2.setId(2L);
        assertThat(claretoOrganization1).isNotEqualTo(claretoOrganization2);
        claretoOrganization1.setId(null);
        assertThat(claretoOrganization1).isNotEqualTo(claretoOrganization2);
    }
}
