package org.sbadin.net.market.allorConnect;

import org.sbadin.net.market.allorConnect.domain.TimeFrame;
import org.sbadin.net.market.allorConnect.domain.Token;
import org.sbadin.net.market.allorConnect.domain.general.History;
import retrofit2.Call;
import retrofit2.http.Query;


public interface AlorApiRestNonSecurityClient {

  Token getAccessToken(String token);



}
