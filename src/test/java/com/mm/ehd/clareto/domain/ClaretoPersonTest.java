package com.mm.ehd.clareto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mm.ehd.clareto.web.rest.TestUtil;

public class ClaretoPersonTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClaretoPerson.class);
        ClaretoPerson claretoPerson1 = new ClaretoPerson();
        claretoPerson1.setId(1L);
        ClaretoPerson claretoPerson2 = new ClaretoPerson();
        claretoPerson2.setId(claretoPerson1.getId());
        assertThat(claretoPerson1).isEqualTo(claretoPerson2);
        claretoPerson2.setId(2L);
        assertThat(claretoPerson1).isNotEqualTo(claretoPerson2);
        claretoPerson1.setId(null);
        assertThat(claretoPerson1).isNotEqualTo(claretoPerson2);
    }
}
