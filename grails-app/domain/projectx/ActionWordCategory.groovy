package projectx

class ActionWordCategory {
    /**
     * actual text content of the action word
     */
    String actionWordCategory

    static belongsTo = [
            /**
             * specific learning domain category that will pull up this action word category
             */
            domainCategory: DomainCategory
    ]

    static mapping = {
        sort 'actionWordCategory'
        version false
    }

    String toString() {
        actionWordCategory
    }
}
