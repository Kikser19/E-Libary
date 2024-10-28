package mk.ukim.finki.emt.emtlabs.listeners;

import mk.ukim.finki.emt.emtlabs.model.events.BookCreatedEvent;
import mk.ukim.finki.emt.emtlabs.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {
    private final BookService bookService;

    public BookEventHandlers(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onBookCreated(BookCreatedEvent bookCreatedEvent){
        this.bookService.refreshMaterializedView();
    }
}
