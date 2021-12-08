package com.example.demouniverse.services;

import java.util.List;

public interface BaseService<TDOT, TFORM, TID> {

    List<TDOT> getAll();

    TDOT getOneById(TID id);

    TDOT insert(TFORM form);

    TID delete(TID id);

    TDOT update(TFORM form, TID id);
}