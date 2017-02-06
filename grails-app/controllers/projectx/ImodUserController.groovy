package projectx

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ImodUserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ImodUser.list(params), model:[imodUserCount: ImodUser.count()]
    }

    def show(ImodUser imodUser) {
        respond imodUser
    }

    def create() {
        respond new ImodUser(params)
    }

    @Transactional
    def save(ImodUser imodUser) {
        if (imodUser == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (imodUser.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond imodUser.errors, view:'create'
            return
        }

        imodUser.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'imodUser.label', default: 'ImodUser'), imodUser.id])
                redirect imodUser
            }
            '*' { respond imodUser, [status: CREATED] }
        }
    }

    def edit(ImodUser imodUser) {
        respond imodUser
    }

    @Transactional
    def update(ImodUser imodUser) {
        if (imodUser == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (imodUser.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond imodUser.errors, view:'edit'
            return
        }

        imodUser.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'imodUser.label', default: 'ImodUser'), imodUser.id])
                redirect imodUser
            }
            '*'{ respond imodUser, [status: OK] }
        }
    }

    @Transactional
    def delete(ImodUser imodUser) {

        if (imodUser == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        imodUser.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'imodUser.label', default: 'ImodUser'), imodUser.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'imodUser.label', default: 'ImodUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
