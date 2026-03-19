package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ALLERGY_ASPIRIN;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.tag.Allergy;
import seedu.address.model.tag.Condition;
import seedu.address.model.tag.Tag;

public class JsonAdaptedTagTest {

    @Test
    public void toModelType_validAllergyTag_returnsAllergy() throws Exception {
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag("allergy:Aspirin");
        Tag modelTag = adaptedTag.toModelType();

        assertEquals(Allergy.class, modelTag.getClass());
    }

    @Test
    public void toModelType_validConditionTag_returnsCondition() throws Exception {
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag("condition:asthma");
        Tag modelTag = adaptedTag.toModelType();

        assertEquals(Condition.class, modelTag.getClass());
    }

    @Test
    public void toModelType_invalidTag_throwsException() {
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag("#invalid");

        org.junit.jupiter.api.Assertions.assertThrows(
                seedu.address.commons.exceptions.IllegalValueException.class,
                adaptedTag::toModelType
        );
    }

    @Test
    public void toModelType_unknownPrefix_throwsException() {
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag("unknown:sometag");

        assertThrows(
            seedu.address.commons.exceptions.IllegalValueException.class,
            adaptedTag::toModelType
        );
    }

    @Test
    public void toJson_jsonCreatorConstructor_returnsTagNameOnly() throws Exception {
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag(VALID_ALLERGY_ASPIRIN);
        assertEquals(VALID_ALLERGY_ASPIRIN, adaptedTag.toJson());
    }

    @Test
    public void constructor_fromModelTag_createsCorrectType() throws Exception {
        Tag allergy = new Allergy(VALID_ALLERGY_ASPIRIN);
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag(allergy);

        Tag result = adaptedTag.toModelType();

        assertEquals(Allergy.class, result.getClass());
    }

    @Test
    public void toJson_conditionTag_returnsConditionPrefix() throws Exception {
        Tag condition = new Condition("asthma");
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag(condition);
        assertEquals("condition:asthma", adaptedTag.toJson());
    }

    @Test
    public void toJson_allergyTag_returnsAllergyPrefix() throws Exception {
        Tag allergy = new Allergy(VALID_ALLERGY_ASPIRIN);
        JsonAdaptedTag adaptedTag = new JsonAdaptedTag(allergy);
        assertEquals("allergy:Aspirin", adaptedTag.toJson());
    }
}
