package projectx

class ResourceType {
    String description

    static mapping = {
        version false
    }

    String toString() {
        description
    }
}