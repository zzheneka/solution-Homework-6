public class FAQBotHandler implements SupportHandler {
    private SupportHandler next;

    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(String issue) {
        if ("password_reset".equals(issue)) {
            System.out.println("[FAQBot] Handled " + issue);
        } else if (next != null) {
            System.out.println("[FAQBot] Passing to next level...");
            next.handle(issue);
        } else {
            System.out.println("[FAQBot] Cannot handle " + issue);
        }
    }
}
