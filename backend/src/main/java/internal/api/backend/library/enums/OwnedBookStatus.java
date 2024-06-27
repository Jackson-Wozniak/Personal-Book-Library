package internal.api.backend.library.enums;

public enum OwnedBookStatus {
    IN_PROGRESS {
        @Override
        public String toString(){
            return "In Progress";
        }
    },
    Completed {
        @Override
        public String toString(){
            return "Completed";
        }
    },
    NOT_STARTED {
        @Override
        public String toString(){
            return "Not Started";
        }
    }
}
