package Kursach.KnifeShop.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FirmsNotFoundException extends RuntimeException {
    private final Long id;
}