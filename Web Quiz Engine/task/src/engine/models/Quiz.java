package engine.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @NotBlank
    @Column
    private String title;

    @NotBlank
    @Column
    private String text;

    @Column
    @Size(min=2) @NotNull
    @ElementCollection
    private List<String> options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    @ElementCollection
    private List<Integer> answer;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH)
    private User author;

}