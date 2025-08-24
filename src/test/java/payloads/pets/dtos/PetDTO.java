package payloads.pets.dtos;

import payloads.pets.records.Category;
import payloads.pets.records.Tags;

import java.util.List;

public class PetDTO {
    private int id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;

    private PetDTO(PetDTOBuilder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.category = builder.getCategory();
        this.photoUrls = builder.getPhotoUrls();
        this.tags = builder.getTags();
        this.status = builder.getStatus();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public static PetDTOBuilder builder(){
        return new PetDTOBuilder();
    }

    public static class PetDTOBuilder{
        private int id;
        private String name;
        private Category category;
        private List<String> photoUrls;
        private List<Tags> tags;
        private String status;

        public PetDTOBuilder id(int id){
            this.id = id;
            return this;
        }
        public int getId(){
            return id;
        }

        public PetDTOBuilder name(String name){
            this.name = name;
            return this;
        }

        public String getName(){
            return name;
        }

        public PetDTOBuilder category(Category category){
            this.category = category;
            return this;
        }

        public Category getCategory(){
            return category;
        }

        public PetDTOBuilder photoUrls(List<String> photoUrls){
            this.photoUrls = photoUrls;
            return this;
        }

        public List<String> getPhotoUrls(){
            return photoUrls;
        }

        public PetDTOBuilder tags(List<Tags> tags){
            this.tags = tags;
            return this;
        }

        public List<Tags> getTags(){
            return tags;
        }

        public PetDTOBuilder status(String status){
            this.status = status;
            return this;
        }

        public String getStatus(){
            return status;
        }

        public PetDTO build(){
            return new PetDTO(this);
        }

    }
}
