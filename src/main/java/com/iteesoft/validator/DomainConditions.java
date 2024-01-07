package com.iteesoft.validator;



import com.iteesoft.validator.domains.ErrorType;
import com.iteesoft.validator.exceptions.*;
import jakarta.annotation.Nonnull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import java.util.Collection;
import java.util.Optional;

@UtilityClass
@Slf4j
public class DomainConditions {

    public static void checkEntityExists(boolean exists) {
        checkEntityExists(exists, null);
    }

    public static void checkEntityExists(boolean exists, @Nullable ErrorType errorType) {
        if (!exists) {
            String name = errorType != null ? errorType.getName() : null;
            String msg = errorType != null ? errorType.getMessage() : null;
            throw new NoSuchEntityException(name, msg, null);
        }
    }

    @Nonnull
    public static <T> T checkEntityExists(Optional<T> optEntity) throws NoSuchEntityException {
        return checkEntityExists(optEntity.orElse(null));
    }

    @Nonnull
    public static <T> T checkEntityExists(Optional<T> optEntity, @Nullable ErrorType errorType) throws NoSuchEntityException {
        return checkEntityExists(optEntity.orElse(null), errorType);
    }

    @Nonnull
    public static <T> T checkEntityExists(@Nullable T entity) throws NoSuchEntityException {
        return checkEntityExists(entity, null);
    }

    @Nonnull
    public static <T> T checkEntityExists(@Nullable T entity, @Nullable ErrorType errorType) throws NoSuchEntityException {
        checkEntityExists(entity != null, errorType);
        return entity;
    }

    @Nonnull
    public static <T> T checkEntityExists(@Nullable T entity, String format, Object... args) throws NoSuchEntityException {
        if (entity == null) {
            throw new NoSuchEntityException(String.format(format, args));
        }
        return entity;
    }

    public static <T> void checkEntityDoesNotExist(@Nullable T entity) throws EntityExistException {
        if (entity != null) {
            throw new EntityExistException();
        }
    }

    public static <T> void checkEntityDoesNotExist(@Nullable Boolean exists) throws EntityExistException {
        if (BooleanUtils.isTrue(exists)) {
            throw new EntityExistException();
        }
    }

    public static void checkAuthorized(boolean authorized) {
        if (!authorized) {
            throw new UnauthorizedException();
        }
    }

    public static <T> T checkAuthorized(Optional<T> optAuth) {
        return checkAuthorized(optAuth.orElse(null));
    }

    @Nonnull
    public static <T> T checkAuthorized(@Nullable T auth) {
        checkAuthorized(auth != null);
        return auth;
    }

    @Nonnull
    public static <T> T checkAllowed(@Nullable T auth) {
        if (auth == null) {
            throw new ForbiddenException();
        }
        return auth;
    }

    @Nonnull
    public static Boolean checkAllowed(@Nullable Boolean allowed) {
        if (BooleanUtils.isNotTrue(allowed)) {
            throw new ForbiddenException();
        }
        return allowed;
    }

    public static void checkRolesAllowed(Collection<String> allowedRoles, String role) {
        if (allowedRoles.isEmpty() || StringUtils.isEmpty(role) || !allowedRoles.contains(role)) {
            throw new ForbiddenException();
        }
    }

    public static void checkExpression(boolean expression, String message) {
        if (!expression) {
            throw new BadRequestException(message);
        }
    }

    public static void checkExpression(boolean expression, String messageFormat, Object... args) {
        if (!expression) {
            String message = String.format(messageFormat, args);
            throw new BadRequestException(message);
        }
    }

    public static void checkExpression(boolean expression, ErrorType errorType) {
        if (!expression) {
            String name = errorType != null ? errorType.getName() : null;
            String msg = errorType != null ? errorType.getMessage() : null;
            throw new BadRequestException(name, msg, null);
        }
    }

    public static <T> T checkNonnullArgument(@Nullable T entity, ErrorType errorType) {
        if (entity == null) {
            String name = errorType != null ? errorType.getName() : null;
            String msg = errorType != null ? errorType.getMessage() : null;
            throw new BadRequestException(name, msg, null);
        }
        return entity;
    }

}

