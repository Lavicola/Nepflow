package com.nepflow.ChatModule.Controller;

import com.nepflow.ChatModule.Dto.ChatDTO;
import com.nepflow.ChatModule.Dto.ChatSummaryDTO;
import com.nepflow.ChatModule.Dto.NewMessageDTO;
import jakarta.annotation.Generated;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link ChatApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-05T00:20:35.211257800+01:00[Europe/Berlin]", comments = "Generator version: 7.6.0")
public interface ChatApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /chats/{chatId} : get one Chat and it´s messages
     *
     * @param chatId  (required)
     * @param pageable  (required)
     * @return OK (status code 200)
     * @see ChatApi#chatsChatIdGet
     */
    default ResponseEntity<ChatDTO> chatsChatIdGet(Integer chatId,
        Pageable pageable) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"user1\" : { \"username\" : \"username\" }, \"user2\" : { \"username\" : \"username\" }, \"name\" : \"name\", \"messages\" : [ { \"sender\" : { \"username\" : \"username\" }, \"id\" : 6, \"content\" : \"content\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }, { \"sender\" : { \"username\" : \"username\" }, \"id\" : 6, \"content\" : \"content\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" } ], \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /chats/{chatId} : add a Message to a Chat
     *
     * @param chatId  (required)
     * @param newMessageDTO  (required)
     * @return OK (status code 200)
     * @see ChatApi#chatsChatIdPost
     */
    default ResponseEntity<NewMessageDTO> chatsChatIdPost(Integer chatId,
        NewMessageDTO newMessageDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"content\" : \"content\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /chats/ : get a summary of Chats from the currently logged in User
     *
     * @param pageable  (required)
     * @return OK (status code 200)
     * @see ChatApi#chatsGet
     */
    default ResponseEntity<List<ChatSummaryDTO>> chatsGet(Pageable pageable) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ \"\", \"\" ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
