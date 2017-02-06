package projectx

import projectx.ActionWordCategory
import projectx.KnowledgeDimension
//import projectx.ContentPriorityCode
import projectx.ResourceType
import projectx.DomainCategory
//import projectx.Help
import projectx.Imod
import projectx.ImodUser
//import projectx.ImodUserRole
import projectx.LearningDomain
//import projectx.PedagogyActivity
//import projectx.PedagogyActivityDuration
//import projectx.PedagogyActivityFocus
//import projectx.PedagogyMode
//import projectx.PedagogyReference
//import projectx.PedagogyReferenceType
//import projectx.PedagogyTechnique
import projectx.AssessmentTechnique
//import projectx.Role
//import projectx.ScheduleRepeats
//import projectx.ScheduleRepeatsEvery
//import projectx.ScheduleWeekDays
//import projectx.Audience
import projectx.AssessmentFeedback


class BootStrap {

    def init = { servletContext ->
        def tempRole
        def adminRole

        /**
         * Generates the user security roles
         */
        if (ImodUser.list().size() == 0) {


            def developer = new ImodUser(
                    username: 'postgres',
                    password: 'postgres',
                    enabled: true,
                    accountExpired: false,
                    accountLocked: false,
                    passwordExpired: false,
                    firstName: 'Jane',
                    lastName: 'Doe ',

                    email: 'imod.grails@gmail.com'
            ).save()



            // Create Admin user
            def admin = new ImodUser(
                    username: 'imodadmin',
                    password: 'imodadmin',
                    enabled: true,
                    accountExpired: false,
                    accountLocked: false,
                    passwordExpired: false,
                    firstName: 'John',
                    lastName: 'Doe ',
                    role: 'Associate Professor',
                    email: 'contact@rahulparekh.in'
            ).save()



            /**
             * Generate Learning Domains, Domain Categories and Action Words
             */
            def learningDomainCognitive = new LearningDomain(
                    name: 'Cognitive'
            ).save()

            def learningDomainAffective = new LearningDomain(
                    name: 'Affective'
            ).save()

            def learningDomainPsychomotor = new LearningDomain(
                    name: 'Psychomotor'
            ).save()

            /**
             * This creates the domain Category instances,
             * these are used to link Learning Domains to Action Words
             */

            /**
             * These are the Categories for the Cognitive Domain
             */
            def domainCategoryRemembering = new DomainCategory(
                    domain: learningDomainCognitive,
                    name: 'Remember',
                    priority: 1
            )

            def domainCategoryUnderstanding = new DomainCategory(
                    domain: learningDomainCognitive,
                    name: 'Understand',
                    priority: 2
            )

            def domainCategoryApplying = new DomainCategory(
                    domain: learningDomainCognitive,
                    name: 'Apply',
                    priority: 3
            )

            def domainCategoryAnalyzing = new DomainCategory(
                    domain: learningDomainCognitive,
                    name: 'Analyze',
                    priority: 4
            )

            def domainCategoryEvaluating = new DomainCategory(
                    domain: learningDomainCognitive,
                    name: 'Evaluate',
                    priority: 5

            )

            def domainCategoryCreating = new DomainCategory(
                    domain: learningDomainCognitive,
                    name: 'Create',
                    priority: 6
            )

            /**
             * This Links each Domain Category to its Learning Domain
             */
            learningDomainCognitive.addToDomainCategories(domainCategoryRemembering)
            learningDomainCognitive.addToDomainCategories(domainCategoryUnderstanding)
            learningDomainCognitive.addToDomainCategories(domainCategoryApplying)
            learningDomainCognitive.addToDomainCategories(domainCategoryAnalyzing)
            learningDomainCognitive.addToDomainCategories(domainCategoryEvaluating)
            learningDomainCognitive.addToDomainCategories(domainCategoryCreating)

            /**
             * These are the Categories for the Affective Domain
             */
            def domainCategoryReceivingPhenomena = new DomainCategory(
                    domain: learningDomainAffective,
                    name: 'Receiving Phenomena',
                    priority: 1
            )

            def domainCategoryResponding = new DomainCategory(
                    domain: learningDomainAffective,
                    name: 'Respond',
                    priority: 2
            )

            def domainCategoryValuing = new DomainCategory(
                    domain: learningDomainAffective,
                    name: 'Value',
                    priority: 3
            )

            def domainCategoryOrganisation = new DomainCategory(
                    domain: learningDomainAffective,
                    name: 'Organization',
                    priority: 4
            )

            def domainCategoryInternalisingValues = new DomainCategory(
                    domain: learningDomainAffective,
                    name: 'Internalizing Values',
                    priority: 5
            )

            /**
             * This Links each Domain Category to its Learning Domain
             */
            learningDomainAffective.addToDomainCategories(domainCategoryReceivingPhenomena)
            learningDomainAffective.addToDomainCategories(domainCategoryResponding)
            learningDomainAffective.addToDomainCategories(domainCategoryValuing)
            learningDomainAffective.addToDomainCategories(domainCategoryOrganisation)
            learningDomainAffective.addToDomainCategories(domainCategoryInternalisingValues)

            /**
             * These are the Categories for the Psychomotor Domain
             */
            def domainCategoryPerception = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Perception',
                    priority: 1
            )

            def domainCategorySet = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Set',
                    priority: 2
            )

            def domainCategoryGuidedResponse = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Guided Response',
                    priority: 3
            )

            def domainCategoryMechanism = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Mechanism',
                    priority: 4
            )

            def domainCategoryComplexOvertResponse = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Complex Overt Response',
                    priority: 5
            )

            def domainCategoryAdaptation = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Adaptation',
                    priority: 6
            )

            def domainCategoryOrigination = new DomainCategory(
                    domain: learningDomainPsychomotor,
                    name: 'Origination',
                    priority: 7
            )

            /**
             * This Links each Domain Category to its Learning Domain
             */
            learningDomainPsychomotor.addToDomainCategories(domainCategoryPerception)
            learningDomainPsychomotor.addToDomainCategories(domainCategorySet)
            learningDomainPsychomotor.addToDomainCategories(domainCategoryGuidedResponse)
            learningDomainPsychomotor.addToDomainCategories(domainCategoryMechanism)
            learningDomainPsychomotor.addToDomainCategories(domainCategoryComplexOvertResponse)
            learningDomainPsychomotor.addToDomainCategories(domainCategoryAdaptation)
            learningDomainPsychomotor.addToDomainCategories(domainCategoryOrigination)


            /**
             * creating action words for remembering category
             */
            def actionWordCategoryRecognizing = new ActionWordCategory(
                    domainCategory: domainCategoryRemembering,
                    actionWordCategory: 'Recognize'
            )

            def actionWordCategoryRecalling = new ActionWordCategory(
                    domainCategory: domainCategoryRemembering,
                    actionWordCategory: 'Recall'
            )

            /**
             * relating the words to the category
             */
            domainCategoryRemembering.addToActionWordCategories(actionWordCategoryRecognizing)
            domainCategoryRemembering.addToActionWordCategories(actionWordCategoryRecalling)

            /**
             * Saving the action words and the domain category
             */
            domainCategoryRemembering.save()

            /**
             * creating action words for understanding category
             */
            def actionWordCategoryInterpreting = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Interpret'
            )

            def actionWordCategoryExemplifying = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Exemplify'
            )

            def actionWordCategoryClassifying = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Classify'
            )

            def actionWordCategorySummarizing = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Summarize'
            )

            def actionWordCategoryInferring = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Infer'
            )

            def actionWordCategoryComparing = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Compare'
            )

            def actionWordCategoryExplaining = new ActionWordCategory(
                    domainCategory: domainCategoryUnderstanding,
                    actionWordCategory: 'Explain'
            )

            /**
             * relating the words to the category
             */
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategoryInterpreting)
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategoryExemplifying)
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategoryClassifying)
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategorySummarizing)
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategoryInferring)
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategoryComparing)
            domainCategoryUnderstanding.addToActionWordCategories(actionWordCategoryExplaining)

            /**
             * Saving the action words and the domain category
             */
            domainCategoryUnderstanding.save()

            /**
             * creating action words for applying category
             */
            def actionWordCategoryExecuting = new ActionWordCategory(
                    domainCategory: domainCategoryApplying,
                    actionWordCategory: 'Execute'
            )

            def actionWordCategoryImplementing = new ActionWordCategory(
                    domainCategory: domainCategoryApplying,
                    actionWordCategory: 'Implement'
            )

            /**
             * relating the words to the category
             */
            domainCategoryApplying.addToActionWordCategories(actionWordCategoryExecuting)
            domainCategoryApplying.addToActionWordCategories(actionWordCategoryImplementing)

            /**
             * Saving the action words and the domain category
             */
            domainCategoryApplying.save()

            /**
             * creating action words for analyzing category
             */
            def actionWordCategoryDifferentiating = new ActionWordCategory(
                    domainCategory: domainCategoryAnalyzing,
                    actionWordCategory: 'Differentiate'
            )

            def actionWordCategoryOrganizing = new ActionWordCategory(
                    domainCategory: domainCategoryAnalyzing,
                    actionWordCategory: 'Organize'
            )

            def actionWordCategoryAttributing = new ActionWordCategory(
                    domainCategory: domainCategoryAnalyzing,
                    actionWordCategory: 'Attribute'
            )

            /**
             * relating the words to the category
             */
            domainCategoryAnalyzing.addToActionWordCategories(actionWordCategoryDifferentiating)
            domainCategoryAnalyzing.addToActionWordCategories(actionWordCategoryOrganizing)
            domainCategoryAnalyzing.addToActionWordCategories(actionWordCategoryAttributing)

            /**
             * Saving the action words and the domain category
             */
            domainCategoryAnalyzing.save()

            /**
             * creating action words for evaluating category
             */
            def actionWordCategoryChecking = new ActionWordCategory(
                    domainCategory: domainCategoryEvaluating,
                    actionWordCategory: 'Check'
            )

            def actionWordCategoryCritiquing = new ActionWordCategory(
                    domainCategory: domainCategoryEvaluating,
                    actionWordCategory: 'Critique'
            )

            /**
             * relating the words to the category
             */
            domainCategoryEvaluating.addToActionWordCategories(actionWordCategoryChecking)
            domainCategoryEvaluating.addToActionWordCategories(actionWordCategoryCritiquing)

            /**
             * Saving the action words and the domain category
             */
            domainCategoryEvaluating.save()

            /**
             * creating action words for evaluating category
             */
            def actionWordCategoryGenerating = new ActionWordCategory(
                    domainCategory: domainCategoryCreating,
                    actionWordCategory: 'Generate'
            )

            def actionWordCategoryPlanning = new ActionWordCategory(
                    domainCategory: domainCategoryCreating,
                    actionWordCategory: 'Plan'
            )

            def actionWordCategoryProducing = new ActionWordCategory(
                    domainCategory: domainCategoryCreating,
                    actionWordCategory: 'Produce'
            )

            /**
             * relating the words to the category
             */
            domainCategoryCreating.addToActionWordCategories(actionWordCategoryGenerating)
            domainCategoryCreating.addToActionWordCategories(actionWordCategoryPlanning)
            domainCategoryCreating.addToActionWordCategories(actionWordCategoryProducing)

            /**
             * Saving the action words and the domain category
             */
            domainCategoryCreating.save()

            /**
             * creating action words for ReceivingPhenomena category
             */
            def actionWordCategoryListens = new ActionWordCategory(
                    domainCategory: domainCategoryReceivingPhenomena,
                    actionWordCategory: 'Listens'
            )

            def actionWordCategoryRemembers = new ActionWordCategory(
                    domainCategory: domainCategoryReceivingPhenomena,
                    actionWordCategory: 'Remembers'
            )

            def actionWordCategoryNames = new ActionWordCategory(
                    domainCategory: domainCategoryReceivingPhenomena,
                    actionWordCategory: 'Names'
            )

            /**
             * relating the words to the category
             */
            domainCategoryReceivingPhenomena.addToActionWordCategories(actionWordCategoryListens)
            domainCategoryReceivingPhenomena.addToActionWordCategories(actionWordCategoryRemembers)
            domainCategoryReceivingPhenomena.addToActionWordCategories(actionWordCategoryNames)

            domainCategoryReceivingPhenomena.save()

            /**
             * creating action words for Responding category
             */
            def actionWordCategoryParticipates = new ActionWordCategory(
                    domainCategory: domainCategoryResponding,
                    actionWordCategory: 'Participates'
            )

            def actionWordCategoryDiscusses = new ActionWordCategory(
                    domainCategory: domainCategoryResponding,
                    actionWordCategory: 'Discusses'
            )

            def actionWordCategoryPractices = new ActionWordCategory(
                    domainCategory: domainCategoryResponding,
                    actionWordCategory: 'Practices'
            )
            /**
             * relating the words to the category
             */
            domainCategoryResponding.addToActionWordCategories(actionWordCategoryParticipates)
            domainCategoryResponding.addToActionWordCategories(actionWordCategoryDiscusses)
            domainCategoryResponding.addToActionWordCategories(actionWordCategoryPractices)

            domainCategoryResponding.save()

            /**
             * creating action words for Valuing category
             */
            def actionWordCategoryDemonstrates = new ActionWordCategory(
                    domainCategory: domainCategoryValuing,
                    actionWordCategory: 'Demonstrates'
            )

            def actionWordCategoryFollows = new ActionWordCategory(
                    domainCategory: domainCategoryValuing,
                    actionWordCategory: 'Follows'
            )

            def actionWordCategoryProposes = new ActionWordCategory(
                    domainCategory: domainCategoryValuing,
                    actionWordCategory: 'Proposes'
            )
            def actionWordCategoryInforms = new ActionWordCategory(
                    domainCategory: domainCategoryValuing,
                    actionWordCategory: 'Informs'
            )
            /**
             * relating the words to the category
             */
            domainCategoryValuing.addToActionWordCategories(actionWordCategoryDemonstrates)
            domainCategoryValuing.addToActionWordCategories(actionWordCategoryFollows)
            domainCategoryValuing.addToActionWordCategories(actionWordCategoryProposes)
            domainCategoryValuing.addToActionWordCategories(actionWordCategoryInforms)
            domainCategoryValuing.save()

            /**
             * creating action words for Organisation category
             */
            def actionWordCategoryRecognizes = new ActionWordCategory(
                    domainCategory: domainCategoryOrganisation,
                    actionWordCategory: 'Recognizes'
            )

            def actionWordCategoryExplains = new ActionWordCategory(
                    domainCategory: domainCategoryOrganisation,
                    actionWordCategory: 'Explains'
            )

            def actionWordCategoryCreates = new ActionWordCategory(
                    domainCategory: domainCategoryOrganisation,
                    actionWordCategory: 'Creates'
            )
            def actionWordCategoryAlters = new ActionWordCategory(
                    domainCategory: domainCategoryOrganisation,
                    actionWordCategory: 'Alters'
            )
            /**
             * relating the words to the category
             */
            domainCategoryOrganisation.addToActionWordCategories(actionWordCategoryRecognizes)
            domainCategoryOrganisation.addToActionWordCategories(actionWordCategoryExplains)
            domainCategoryOrganisation.addToActionWordCategories(actionWordCategoryCreates)
            domainCategoryOrganisation.addToActionWordCategories(actionWordCategoryAlters)
            domainCategoryOrganisation.save()

            /**
             * creating action words for Internalising Values category
             */
            def actionWordCategoryCooperates = new ActionWordCategory(
                    domainCategory: domainCategoryInternalisingValues,
                    actionWordCategory: 'Cooperates'
            )

            def actionWordCategoryDisplays = new ActionWordCategory(
                    domainCategory: domainCategoryInternalisingValues,
                    actionWordCategory: 'Displays'
            )

            def actionWordCategoryRevises = new ActionWordCategory(
                    domainCategory: domainCategoryInternalisingValues,
                    actionWordCategory: 'Revises'
            )
            def actionWordCategoryUses = new ActionWordCategory(
                    domainCategory: domainCategoryInternalisingValues,
                    actionWordCategory: 'Uses'
            )
            def actionWordCategoryValues = new ActionWordCategory(
                    domainCategory: domainCategoryInternalisingValues,
                    actionWordCategory: 'Values'
            )
            /**
             * relating the words to the category
             */
            domainCategoryInternalisingValues.addToActionWordCategories(actionWordCategoryCooperates)
            domainCategoryInternalisingValues.addToActionWordCategories(actionWordCategoryDisplays)
            domainCategoryInternalisingValues.addToActionWordCategories(actionWordCategoryRevises)
            domainCategoryInternalisingValues.addToActionWordCategories(actionWordCategoryUses)
            domainCategoryInternalisingValues.addToActionWordCategories(actionWordCategoryValues)
            domainCategoryInternalisingValues.save()

            /**
             * creating action words for Perception category
             */
            def actionWordCategoryDetects = new ActionWordCategory(
                    domainCategory: domainCategoryPerception,
                    actionWordCategory: 'Detects'
            )

            def actionWordCategoryAdjusts = new ActionWordCategory(
                    domainCategory: domainCategoryPerception,
                    actionWordCategory: 'Adjusts'
            )

            def actionWordCategoryEstimates = new ActionWordCategory(
                    domainCategory: domainCategoryPerception,
                    actionWordCategory: 'Estimates'
            )

            /**
             * relating the words to the category
             */
            domainCategoryPerception.addToActionWordCategories(actionWordCategoryDetects)
            domainCategoryPerception.addToActionWordCategories(actionWordCategoryAdjusts)
            domainCategoryPerception.addToActionWordCategories(actionWordCategoryEstimates)

            domainCategoryPerception.save()

            /**
             * creating action words for Set category
             */
            def actionWordCategoryKnows = new ActionWordCategory(
                    domainCategory: domainCategorySet,
                    actionWordCategory: 'Knows'
            )

            def actionWordCategoryRecognises = new ActionWordCategory(
                    domainCategory: domainCategorySet,
                    actionWordCategory: 'Recognises'
            )

            def actionWordCategoryShows = new ActionWordCategory(
                    domainCategory: domainCategorySet,
                    actionWordCategory: 'Shows'
            )

            /**
             * relating the words to the category
             */
            domainCategorySet.addToActionWordCategories(actionWordCategoryKnows)
            domainCategorySet.addToActionWordCategories(actionWordCategoryRecognises)
            domainCategorySet.addToActionWordCategories(actionWordCategoryShows)

            domainCategorySet.save()

            /**
             * creating action words for GuidedResponse category
             */
            def actionWordCategoryPerforms = new ActionWordCategory(
                    domainCategory: domainCategoryGuidedResponse,
                    actionWordCategory: 'Performs'
            )

            def actionWordCategoryFollowing = new ActionWordCategory(
                    domainCategory: domainCategoryGuidedResponse,
                    actionWordCategory: 'Following'
            )

            def actionWordCategoryResponds = new ActionWordCategory(
                    domainCategory: domainCategoryGuidedResponse,
                    actionWordCategory: 'Responds'
            )

            /**
             * relating the words to the category
             */
            domainCategoryGuidedResponse.addToActionWordCategories(actionWordCategoryPerforms)
            domainCategoryGuidedResponse.addToActionWordCategories(actionWordCategoryFollowing)
            domainCategoryGuidedResponse.addToActionWordCategories(actionWordCategoryResponds)

            domainCategoryGuidedResponse.save()

            /**
             * creating action words for Mechanism category
             */
            def actionWordCategoryUsing = new ActionWordCategory(
                    domainCategory: domainCategoryMechanism,
                    actionWordCategory: 'Using'
            )

            def actionWordCategoryRepairs = new ActionWordCategory(
                    domainCategory: domainCategoryMechanism,
                    actionWordCategory: 'Repairs'
            )

            def actionWordCategoryDrives = new ActionWordCategory(
                    domainCategory: domainCategoryMechanism,
                    actionWordCategory: 'Drives'
            )

            /**
             * relating the words to the category
             */
            domainCategoryMechanism.addToActionWordCategories(actionWordCategoryUsing)
            domainCategoryMechanism.addToActionWordCategories(actionWordCategoryRepairs)
            domainCategoryMechanism.addToActionWordCategories(actionWordCategoryDrives)

            domainCategoryMechanism.save()


            /**
             * creating action words for ComplexOvertResponse category
             */
            def actionWordCategoryManeuvers = new ActionWordCategory(
                    domainCategory: domainCategoryComplexOvertResponse,
                    actionWordCategory: 'Maneuvers'
            )

            def actionWordCategoryOperates = new ActionWordCategory(
                    domainCategory: domainCategoryComplexOvertResponse,
                    actionWordCategory: 'Operates'
            )

            def actionWordCategoryDisplaying = new ActionWordCategory(
                    domainCategory: domainCategoryComplexOvertResponse,
                    actionWordCategory: 'Displays'
            )

            /**
             * relating the words to the category
             */
            domainCategoryComplexOvertResponse.addToActionWordCategories(actionWordCategoryManeuvers)
            domainCategoryComplexOvertResponse.addToActionWordCategories(actionWordCategoryOperates)
            domainCategoryComplexOvertResponse.addToActionWordCategories(actionWordCategoryDisplaying)

            domainCategoryComplexOvertResponse.save()

            /**
             * creating action words for Adaptation category
             */
            def actionWordCategoryResponse = new ActionWordCategory(
                    domainCategory: domainCategoryAdaptation,
                    actionWordCategory: 'Response'
            )

            def actionWordCategoryPerforming = new ActionWordCategory(
                    domainCategory: domainCategoryAdaptation,
                    actionWordCategory: 'Perform'
            )

            def actionWordCategoryModifies = new ActionWordCategory(
                    domainCategory: domainCategoryAdaptation,
                    actionWordCategory: 'Modifies'
            )

            /**
             * relating the words to the category
             */
            domainCategoryAdaptation.addToActionWordCategories(actionWordCategoryResponse)
            domainCategoryAdaptation.addToActionWordCategories(actionWordCategoryPerforming)
            domainCategoryAdaptation.addToActionWordCategories(actionWordCategoryModifies)

            domainCategoryAdaptation.save()

            /**
             * creating action words for Origination category
             */
            def actionWordCategoryConstructs = new ActionWordCategory(
                    domainCategory: domainCategoryOrigination,
                    actionWordCategory: 'Constructs'
            )

            def actionWordCategoryDevelops = new ActionWordCategory(
                    domainCategory: domainCategoryOrigination,
                    actionWordCategory: 'Develops'
            )

            def actionWordCategoryCreating = new ActionWordCategory(
                    domainCategory: domainCategoryOrigination,
                    actionWordCategory: 'Creating'
            )

            /**
             * relating the words to the category
             */
            domainCategoryOrigination.addToActionWordCategories(actionWordCategoryConstructs)
            domainCategoryOrigination.addToActionWordCategories(actionWordCategoryDevelops)
            domainCategoryOrigination.addToActionWordCategories(actionWordCategoryCreating)

            domainCategoryOrigination.save()

            def knowledgeDimensions = [
                    [
                            description: 'Factual',
                            info: 'The knowledge of terminology, details, or elements.'
                    ], [
                            description: 'Conceptual',
                            info: 'The knowledge classifications, generalizations, and theories.'
                    ], [
                            description: 'Procedural',
                            info: 'The knowledge of subject specific skills and techniques;the knowledge of criteria for when to use appropriate procedures'
                    ], [
                            description: 'Metacognitive',
                            info: 'The knowledge about cognitive tasks; strategic knowledge and self-knowledge.'
                    ]
            ]

            knowledgeDimensions.each {
                new KnowledgeDimension(it).save()
            }

            new ResourceType(
                    description: 'Document'
            ).save()

            new ResourceType(
                    description: 'Book'
            ).save()

            new ResourceType(
                    description: 'Chapter'
            ).save()

            new ResourceType(
                    description: 'URL'
            ).save()

            new AssessmentFeedback(
                    name: 'In Person'
            ).save()

            new AssessmentFeedback(
                    name: 'Online'
            ).save()

            new AssessmentFeedback(
                    name: 'Both'
            ).save()


            // All the assessment techniques
            def assessments = [
                    [
                            title: 'Minute Papers',
                            learningDomain: LearningDomain.findAllByNameInList([
                                    'Cognitive'
                            ]),//'Cognitive','Affective', 'Psychomotor'
                            domainCategory: DomainCategory.findAllByNameInList([
                                    'Remember'
                            ]),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList([
                                    'Factual',
                                    'Conceptual',
                                    'Procedural',
                                    'Metacognitive'
                            ]),
                            assessmentFeedback: AssessmentFeedback.findByName('Online'),
                            isAdmin: true
                    ],
                    [
                            title: 'Background Knowledge Probe',
                            description: 'This activity goes beyond the common practice of asking students what courses they have already taken in the field. Using a survey, the instructor elicits information that can be used to focus instruction on appropriate content and level of difficulty.',
                            procedure: '',
                            duration: '15',
                            difficulty: 'Low',
                            whenToCarryOut: 'Pre',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Remember', 'Understand']),
                            isAdmin: true
                    ],


                    [
                            title: 'Student-generated Test questions',
                            description: 'By having students write test questions and compose answers, faculty discover what students identify as key content, what they consider reasonable test questions and how well they can answer the questions they create. Instructors pre-determine the types of questions (essay, multiple choice, shortanswer, etc.) and the topics to be addressed. The questions can then be compiled for a study guide or, as an added incentive, chosen (if suitable) to appear on the actual test.',
                            procedure: '',
                            duration: '15',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Remember', 'Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Minute paper',
                            description: 'This technique helps ascertain what students felt was the most important information they learned during a particular class meeting and if they have any lingering questions about the content. Answers to these questions help faculty focus instruction, make mid-course corrections or identify areas that need more emphasis.',
                            procedure: '',
                            duration: '1',
                            difficulty: 'Low',
                            whenToCarryOut: 'Pre',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual','Factual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Remember', 'Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Muddiest point',
                            description: 'This very simple technique identifies areas of confusion from a lecture, discussion, homework or other activity. When students write out the answer to the question,  What was the muddiest point in _______? Students not only must reflect on the content material but also articulate their thoughts. This CAT works well when large amounts of information has been presented.',
                            procedure: '',
                            duration: '5',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive', 'Conceptual', 'Factual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Remember', 'Understand', 'Apply']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual','Factual','Procedural', 'Metacognitive']),
                            isAdmin: true
                    ],

                    [
                            title: 'Capstone project',
                            description: 'This is a simple technique in which students apply the concepts they have learnt on a project.',
                            procedure: '',
                            duration: '',
                            difficulty: 'High',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Practicuum or internship',
                            description: 'The purpose of the practicum or internship is to provide students with supervised experience in an actual work setting similar to one in which the student might end up after graduating. Assessment generally involves analysis of work performance by the student’s supervisor, grading of a formal report by the faculty member, and a self-analysis written by the student.',
                            procedure: '',
                            duration: '',
                            difficulty: 'High',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Midterm test',
                            description: 'The purpose of the Midterm test is to assess how much the students have learnt and are able to apply in answering questions related to the coursework.',
                            procedure: '',
                            duration: '120 min',
                            difficulty: 'High',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply', 'Remember']),
                            isAdmin: true
                    ],

                    [
                            title: 'Final Exam',
                            description: 'The purpose of the Final Examis to assess how much the students have learnt and are able to apply in answering questions related to the coursework.',
                            procedure: '',
                            duration: '120 min',
                            difficulty: 'High',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply', 'Remember']),
                            isAdmin: true
                    ],

                    [
                            title: 'Final Project',
                            description: 'This is a simple technique in which students apply the concepts they have learnt on a project.',
                            procedure: '',
                            duration: '',
                            difficulty: 'High',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Focused Listing',
                            description: 'This technique focuses on the students attention on a single important term, name or  concept from a particular lesson or class session and directs them to list several ideas that are closely related to that focus point. It can help the faculty assess how well the students can describe or define a central point in the lesson.',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Memory Matrix',
                            description: 'In a memory matrix the row and column headings are given but the cells the boces within are left empty.When the students fill in these boxes the feedback can be easily scanned and analysed.This technique assesses students recall of important course content and their skill at organizing that information into categories provided by the instructor',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Content,Form,and Function Outlines',
                            description: 'This assessment technique is called the" what how and why "outlines.The student writes brief notes answering the "what ,how and why " question in an outline format that can be quickly read and assessed.This technique is used to assess the students ability at separating and analyzing informational content.',
                            procedure: '',
                            duration: '20 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual', 'Procedural', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],


                    [
                            title: 'Misconception/Preconception Check',
                            description: 'This technique assesses the students prior knowledge by focusing on uncovering prior knowledge that may hinder or block further learning.This technique is designed to uncover specific instances of incorrect or incomplete knowledge,attitudes, values that represent lilely barriers to new learning.',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Perception']),
                            isAdmin: true
                    ],

                    [
                            title: 'Empty Outlines',
                            description: 'The instructor provides students with an empty or partially completed outline of an in class presentation or homework assignment and gives them limited amount of time to fill in the blank spaces.It helps faculty fi nd out how well the students have caught the important points of a lecture.',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Perception', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Categorizing Grid',
                            description: 'This technique  is the paper amnd pencil equivalent of sorting objects in a warehouse and putting the like ones together in a bin.This feedback allows the teacher to determine quickly whether ,how and how well students understand "what goes with what".  ',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Mid',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive', 'Affective']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Mechanism', 'Adaptation', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Defining Features Matrix',
                            description: 'The defining matrix requires student to categorize concpts according to the presence (+) or absence (-) of important defining features thereby providing data on their analtyic and thinking abilities. ',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Mid',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Analytic Memos',
                            description: 'This technique requires the student to write a one to two page analysis of a specific problem or issue.It helps to assess the students ability to communicate the analysis in a clear and concise manner.',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Summative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Word Journal',
                            description: 'The word journal prompts a two part response .First the student summarises a short text in a single word. Second, the student writes a paragraph explaining why he or she chose that particular word to summarize the text.It assesses the students ability to read carefully and creaticely summarize it in a single word',
                            procedure: '',
                            duration: '10 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),

                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Factual']),

                            domainCategory: DomainCategory.findAllByNameInList(['Understand']),

                            domainCategory: DomainCategory.findAllByNameInList(['Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Concept Maps',
                            description: 'Concept maps are drawings or diagrams showing the mental connections that students make between a major concept the instructor focuses on and other concepts they have learned.This technique assesses the patterns of associations they make in relation to a focal concept',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Problem Recognition Tasks',
                            description: 'Problem Recognition Tasks present students with a few examples of common problem types. The students task is to recognize and identify particular type of problem each  example represents.This practice helps students develop a diagnostic skill.',
                            procedure: '',
                            duration: '10 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Mid',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],


                    [
                            title: 'Human Tableau or Class Modeling',
                            description: 'Group of students create "living" scenes or model processes to show what they know. Just as some students learen more effectively by listening,others learn more effectively by movement.This technique works well for kinesthetic learners. ',
                            procedure: '',
                            duration: '15 minutes',
                            difficulty: 'Medium',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive', 'Affective', 'Psychomotor']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Classroom opinion polls',
                            description: 'Many faculty already use de facto opinion polling in their classes when they ask students to raise their hands to indicate agreement  or disagreement with a particular statement.',
                            procedure: '',
                            duration: '10 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Mid',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Interest/Knowledge/Skills Checklist',
                            description: 'Teachers create checklists of topics covered in their courses and skills  strengthened  by or required for succeeding in those courses.Students rate their interest in the various topics and assess their levels of skill or knowledge in those topics, by indicating the appropriate responses on the checklist. ',
                            procedure: '',
                            duration: '10 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Mid',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Goal Ranking and Matching',
                            description: 'Goal Ranking and Matching is a simple procedure that many faculty have adapted to use in first or second day of class. It takes only a few minutes for students to list a few learning they hope to achieve through the course and to rank the relative importance of those goals.',
                            procedure: '',
                            duration: '30 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Pre',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Punctuated Lectures',
                            description: 'This technique requires students and teachers to go through five steps: listen, stop, reflect, write, and give feedback.After a part of the lecture or demonstration the students reflect on what they were doing the presentation and how it aided or hindered their understanding of the information',
                            procedure: '',
                            duration: '5 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Process Analysis',
                            description: 'Process analysis Requires that students keep records of actual steps taken while carrying out a specific assignment and conclusions they draw about their approaches to assignment',
                            procedure: '',
                            duration: '10 minutes',
                            difficulty: 'Low',
                            whenToCarryOut: 'Post',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ],

                    [
                            title: 'Diagnostic Learning Logs',
                            description: 'In Diagnostic learning logs are essentially limited, tightly  focused versions of the academic journals many teachers already use.In these logs, students keep records of each class or assignment.',
                            procedure: '',
                            duration: '',
                            difficulty: 'Low',
                            whenToCarryOut: 'Mid',
                            reference: 'Thomas A. Angelo and K.Patricia Cross. “Classroom Assessment Techniques“, 2nd ed. James Rhem. California: Jossey-Bass.',
                            type: 'Formative',
                            assessmentFeedback: AssessmentFeedback.findByName('In Person'),
                            learningDomain: LearningDomain.findAllByNameInList(['Cognitive']),
                            knowledgeDimension: KnowledgeDimension.findAllByDescriptionInList(['Conceptual', 'Metacognitive']),
                            domainCategory: DomainCategory.findAllByNameInList(['Understand', 'Apply']),
                            isAdmin: true
                    ]

            ]

            // looping through assessments and save them one by one
            def techAssess
            assessments.each {
                techAssess = new AssessmentTechnique()
                techAssess.title = it.title
                techAssess.description = it.description
                techAssess.procedure = it.procedure
                techAssess.duration= it.duration
                techAssess.difficulty = it.low
                techAssess.whenToCarryOut = it.whenToCarryOut
                techAssess.reference = it.reference
                techAssess.type = it.type
                techAssess.assessmentFeedback = it.assessmentFeedback
                it.domainCategory.each { dc ->
                    techAssess.addToDomainCategory(
                            dc
                    )
                }
                it.learningDomain.each { ld ->
                    techAssess.addToLearningDomain(
                            ld
                    )
                }
                it.knowledgeDimension.each { kd ->
                    techAssess.addToKnowledgeDimension(
                            kd
                    )
                }
                techAssess.isAdmin = it.isAdmin
                techAssess.save()
                admin.addToAssessmentTechnique(techAssess).save()
            }


        }
    }
    def destroy = {
    }
}
