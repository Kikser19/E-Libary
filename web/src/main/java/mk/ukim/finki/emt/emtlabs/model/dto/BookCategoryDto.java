package mk.ukim.finki.emt.emtlabs.model.dto;

import lombok.Data;

@Data
public class BookCategoryDto {
    private String name;

    public BookCategoryDto(String name) {
        this.name = name;
    }

    public BookCategoryDto() {
    }
}
