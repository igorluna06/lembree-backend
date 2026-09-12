CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(150)  NOT NULL,
    email VARCHAR(150)  NOT NULL UNIQUE,
    hash_password VARCHAR(255)  NOT NULL,
    standard_deadline_hours INTEGER       NOT NULL DEFAULT 4,
    active_persistent_notification BOOLEAN       NOT NULL DEFAULT TRUE,
    created_on TIMESTAMP     NOT NULL DEFAULT now()
);