public class JuniorSupportHandler implements SupportHandler {
    private SupportHandler next;

    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(String issue) {
        if ("refund_request".equals(issue) || "billing_issue".equals(issue)) {
            System.out.println("[JuniorSupport] Handled " + issue);
        } else if (next != null) {
            System.out.println("[JuniorSupport] Escalating to next level...");
            next.handle(issue);
        } else {
            System.out.println("[JuniorSupport] Cannot handle " + issue);
        }
    }
}
