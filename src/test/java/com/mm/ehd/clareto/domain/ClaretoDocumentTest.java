package com.mm.ehd.clareto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.mm.ehd.clareto.web.rest.TestUtil;

public class ClaretoDocumentTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClaretoDocument.class);
        ClaretoDocument claretoDocument1 = new ClaretoDocument();
        claretoDocument1.setId(1L);
        ClaretoDocument claretoDocument2 = new ClaretoDocument();
        claretoDocument2.setId(claretoDocument1.getId());
        assertThat(claretoDocument1).isEqualTo(claretoDocument2);
        claretoDocument2.setId(2L);
        assertThat(claretoDocument1).isNotEqualTo(claretoDocument2);
        claretoDocument1.setId(null);
        assertThat(claretoDocument1).isNotEqualTo(claretoDocument2);
    }
}
