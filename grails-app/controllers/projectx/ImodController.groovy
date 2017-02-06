package projectx

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ImodController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Imod.list(params), model:[imodCount: Imod.count()]
    }

    def show(Imod imod) {
        def start = System.currentTimeMillis()
        def imodName = Imod.findAllByOwner( ImodUser.findByUsername('postgres') )
        println imodName
        def end= System.currentTimeMillis()
        print end-start + "ms"
        respond imod
    }

    def create() {
        respond new Imod(params)
    }

    @Transactional
    def save(Imod imod) {
        if (imod == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (imod.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond imod.errors, view:'create'
            return
        }

        imod.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'imod.label', default: 'Imod'), imod.id])
                redirect imod
            }
            '*' { respond imod, [status: CREATED] }
        }
    }

    def edit(Imod imod) {
        respond imod
    }

    @Transactional
    def update(Imod imod) {
        if (imod == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (imod.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond imod.errors, view:'edit'
            return
        }

        imod.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'imod.label', default: 'Imod'), imod.id])
                redirect imod
            }
            '*'{ respond imod, [status: OK] }
        }
    }

    @Transactional
    def delete(Imod imod) {

        if (imod == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        imod.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'imod.label', default: 'Imod'), imod.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'imod.label', default: 'Imod'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
