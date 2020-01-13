package com.jbs.JobbSokerDig.values;

import javax.persistence.*;

@Entity
@Table(name = "Preferancelevel")
public class PreferanceLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Preferencelevelid")
    Long PreferenceLevelId;

    @Column(name = "Importancelevel")
    int ImportanceLevel;

    public PreferanceLevel() {
    }

    public PreferanceLevel(Long preferenceLevelId, int importanceLevel) {
        PreferenceLevelId = preferenceLevelId;
        ImportanceLevel = importanceLevel;
    }

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
