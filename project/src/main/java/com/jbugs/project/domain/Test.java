package com.jbugs.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Test {
    @Id @GeneratedValue
    @Column(name="studentId")
    private Long id;

    private Long classId;
    private int year;

    public Test(Long id, Long classId, int year) {
        this.id = id;
        this.classId = classId;
        this.year = year;
    }

}
