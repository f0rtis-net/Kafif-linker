package com.kafif_linker.backend.controller;

import com.kafif_linker.backend.service.LinkShorterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Tag(name = "LinkShorter")
@RestController
@RequestMapping("/api/v1/shorter")
@RequiredArgsConstructor
public class LinkShorterController {
    private final LinkShorterService linkShorterService;

    @PostMapping("/short")
    @Operation(summary = "Check that url is valid, and short it. Returns short version", operationId = "shortLongUrl")
    @ApiResponses ({
            @ApiResponse(responseCode = "200", description = "Successfully shorted."),
            @ApiResponse(responseCode = "400", description = "Invalid url format for shorting.")
    })
    public ResponseEntity<String> shortUrl(@RequestBody String url) {
        return ResponseEntity.ok(linkShorterService.getShortUrlByLong(url));
    }

    @GetMapping("/{shortUrl}")
    @Operation(summary = "Check that url is valid, redirects to long url", operationId = "redirectToLongUrl")
    @ApiResponses({
            @ApiResponse(responseCode = "301", description = "Valid redirect."),
            @ApiResponse(responseCode = "404", description = "Url is invalid, or not registered for redirecting.")
    })
    public RedirectView redirectToLongUrl(@PathVariable String shortUrl) {
        return new RedirectView(linkShorterService.getLongUrlByShort(shortUrl));
    }
}
