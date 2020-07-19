package projektniZadatak.entity.dto;

public class HallDTO {
    private Long id;
    private int capacity;
    private String label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public HallDTO(Long id, int capacity, String label) {
        this.id = id;
        this.capacity = capacity;
        this.label = label;
    }
}
