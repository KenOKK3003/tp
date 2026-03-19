package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ALLERGY_ASPIRIN;

import org.junit.jupiter.api.Test;

public class AllergyTest {

    @Test
    public void constructor_validName_success() {
        Allergy allergy = new Allergy(VALID_ALLERGY_ASPIRIN);
        assertEquals("[Aspirin]", allergy.toString());
    }
}
