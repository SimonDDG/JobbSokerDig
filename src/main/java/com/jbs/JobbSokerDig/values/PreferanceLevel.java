package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "PreferanceLevel")
public class PreferanceLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long PreferenceLevelId;

    @Column(name = "ImportanceLevel")
    int ImportanceLevel;

    public Long getPreferenceLevelId() {
        return PreferenceLevelId;
    }

    public void setPreferenceLevelId(Long preferenceLevelId) {
        PreferenceLevelId = preferenceLevelId;
    }

    public int getImportanceLevel() {
        return ImportanceLevel;
    }

    public void setImportanceLevel(int importanceLevel) {
        ImportanceLevel = importanceLevel;
    }
}
