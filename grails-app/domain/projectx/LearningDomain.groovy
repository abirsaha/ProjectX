package projectx

class LearningDomain {
    String name

    static hasMany=[
            domainCategories: DomainCategory
    ]

    static constraints = {
    }



    static mapping = {
        id generator:'native'
    }

    String toString() {
        name
    }
}