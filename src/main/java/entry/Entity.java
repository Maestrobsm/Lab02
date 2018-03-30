package entry;

import id.CreatorId;

public class Entity extends CreatorId {
    private Long idObj;
    private Long idObjTyp;


    public Entity() {
        this.idObj = getObjectId();
        this.idObjTyp = getTypeId();
    }

    public Long getIdObj() {
        return idObj;
    }

    public void setIdObj(Long idObj) {
        this.idObj = idObj;
    }

    public Long getIdObjTyp() {
        return idObjTyp;
    }

    public void setIdObjTyp(Long idObjTyp) {
        this.idObjTyp = idObjTyp;
    }
}
