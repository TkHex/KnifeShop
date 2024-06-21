package Kursach.KnifeShop.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class KnifesNotFoundException extends RuntimeException{

    private final Long id;
}