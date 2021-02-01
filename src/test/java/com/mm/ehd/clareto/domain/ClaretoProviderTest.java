package com.mm.ehd.clareto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mm.ehd.clareto.web.rest.TestUtil;

public class ClaretoProviderTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClaretoProvider.class);
        ClaretoProvider claretoProvider1 = new ClaretoProvider();
        claretoProvider1.setId(1L);
        ClaretoProvider claretoProvider2 = new ClaretoProvider();
        claretoProvider2.setId(claretoProvider1.getId());
        assertThat(claretoProvider1).isEqualTo(claretoProvider2);
        claretoProvider2.setId(2L);
        assertThat(claretoProvider1).isNotEqualTo(claretoProvider2);
        claretoProvider1.setId(null);
        assertThat(claretoProvider1).isNotEqualTo(claretoProvider2);
    }
}
