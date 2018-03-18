package org.appdirect.challenge.Service;


import org.appdirect.challenge.dto.Response;

public interface UserService {
    public Response assignUser(String eventUrl);
    public Response unassignUser(String eventUrl);
}
