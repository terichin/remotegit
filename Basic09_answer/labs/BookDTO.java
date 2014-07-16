class BookDTO {
    private String bookname;
    private int price;
    
    public BookDTO(String name, int price) {
        this.bookname = name;
        this.price = price;
    }
    
    public String getBookName() {
        return bookname;
    }
    
    public int getPrice() {
        return price;
    }
}
