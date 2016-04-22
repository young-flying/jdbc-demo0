package enums;

public enum StuctType {
	STRING,INT,INTEGER;
	
	public static StuctType valuesOf(String name) {
		 switch (name) {
        case "String":
            return STRING;
        case "int":
            return INT;
        case "Integer":
            return INTEGER;
        default:
            return null;
        }
	}
	
	public String toDbType() {
		switch (this) {
		case STRING:
			return "varchar";
		case INT:
			return "INTEGER";
		case INTEGER:
			return "INTEGER";
		default:
			return "";
		}
	}
}
