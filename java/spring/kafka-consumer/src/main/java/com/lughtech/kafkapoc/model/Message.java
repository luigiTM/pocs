package com.lughtech.kafkapoc.model;

import java.util.UUID;

public record Message(UUID id, String content) {
}
