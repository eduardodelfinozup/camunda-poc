package application.camunda.util;

public class MessagesUtil {

    //boolen
    public static final String BOOLEAN_TRUE = "true";
    public static final String BOOLEAN_FALSE = "false";

    // START CAMUNDA
    public static final String COR_PREDILECT_START = "cor_predilect";
    public static final String SUSPEND_PRODUCTS_START = "SUSPEND_PRODUCT";
    public static final String BUSSINESSkEY = "STAR-CAMUNDA-POC";

    //MESSAGES DE TRATAMENTO DE ERROR
    public static final String ID_PROCESSO_ERROR = "[ processo null ]";
    public static final String STATUS_IS_NULL = "null";
    public static final String MESSAGE_ERROR_500 = "O status não pode ser null ( precisa passar uma String true ou false)";
    public static final String MESSAGE_ERROR_422 = "O status precisa ser true ou false";

    //SET VARIABLES
    public static final String SUB_ID = "SUB-ID";
    public static final String SUBSCRIPTION_ID = "SUB-123456";
    public static final String SHOLD_REBERSE_SUBSCRIPTION_PAYMENT = "shouldReverseSubscriptionPayment";
    public static final String SUBSCRIPTION_IS_SUSPENDED = "subscriptionIsSuspended";
}
