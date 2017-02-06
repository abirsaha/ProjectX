package projectx

class AssessmentFeedback {
    String name

    static hasMany = [
            assessmentTechnique: AssessmentTechnique
    ]

    static mapping = {
        version false
    }

    String toString() {
        name
    }
}