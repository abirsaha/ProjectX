package projectx
/**
 * Created by Abir on 2/5/17.
 */
enum KnowledgeDimensionEnum {
    CONCEPTUAL('Conceptual', 'The knowledge of terminology, details, or elements.'),
    FACTUAL('Factual', 'The knowledge of classifications, generalizations, and theories.'),
    METACOGNITIVE('Metacognitive', 'The knowledge of subject specific skills and techniques; the knowledge of criteria for when to use appropriate procedures.'),
    PROCEDURAL('Procedural', 'The knowledge about cognitive tasks, strategic knowledge and self-knowledge.')

    private final String value
    private final String info

    KnowledgeDimensionEnum(String value, String info) {
        this.value = value
        this.info = info
    }

    String value() {
        value
    }
    String info() {
        info
    }

    @Override
    String toString() {
        value
    }

    String getKey() {
        name()
    }

    String getValue() {
        value
    }

    String getInfo() {
        info
    }
}

