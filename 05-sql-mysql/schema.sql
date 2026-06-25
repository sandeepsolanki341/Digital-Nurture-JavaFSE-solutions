-- =====================================================================
-- Local Community Event Portal — Database Schema
-- ANSI SQL Using MySQL  |  GenC Full-Stack Exercises (Module 05)
-- =====================================================================
-- Run first:  mysql -u root -p < schema.sql
-- Then seed:  mysql -u root -p < seed.sql
-- =====================================================================

DROP DATABASE IF EXISTS event_portal;
CREATE DATABASE event_portal CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE event_portal;

-- ---------------------------------------------------------------------
-- 1. Users
-- ---------------------------------------------------------------------
CREATE TABLE users (
    user_id           INT          PRIMARY KEY AUTO_INCREMENT,
    full_name         VARCHAR(100) NOT NULL,
    email             VARCHAR(100) NOT NULL UNIQUE,
    city              VARCHAR(100) NOT NULL,
    registration_date DATE         NOT NULL
);

-- ---------------------------------------------------------------------
-- 2. Events
-- ---------------------------------------------------------------------
CREATE TABLE events (
    event_id     INT          PRIMARY KEY AUTO_INCREMENT,
    title        VARCHAR(200) NOT NULL,
    description  TEXT,
    city         VARCHAR(100) NOT NULL,
    start_date   DATETIME     NOT NULL,
    end_date     DATETIME     NOT NULL,
    status       ENUM('upcoming','completed','cancelled') NOT NULL DEFAULT 'upcoming',
    organizer_id INT,
    CONSTRAINT fk_events_organizer
        FOREIGN KEY (organizer_id) REFERENCES users(user_id)
);

-- ---------------------------------------------------------------------
-- 3. Sessions
-- ---------------------------------------------------------------------
CREATE TABLE sessions (
    session_id   INT          PRIMARY KEY AUTO_INCREMENT,
    event_id     INT          NOT NULL,
    title        VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time   DATETIME     NOT NULL,
    end_time     DATETIME     NOT NULL,
    CONSTRAINT fk_sessions_event
        FOREIGN KEY (event_id) REFERENCES events(event_id)
);

-- ---------------------------------------------------------------------
-- 4. Registrations
-- ---------------------------------------------------------------------
CREATE TABLE registrations (
    registration_id   INT  PRIMARY KEY AUTO_INCREMENT,
    user_id           INT  NOT NULL,
    event_id          INT  NOT NULL,
    registration_date DATE NOT NULL,
    CONSTRAINT fk_reg_user  FOREIGN KEY (user_id)  REFERENCES users(user_id),
    CONSTRAINT fk_reg_event FOREIGN KEY (event_id) REFERENCES events(event_id)
);

-- ---------------------------------------------------------------------
-- 5. Feedback
-- ---------------------------------------------------------------------
CREATE TABLE feedback (
    feedback_id   INT  PRIMARY KEY AUTO_INCREMENT,
    user_id       INT  NOT NULL,
    event_id      INT  NOT NULL,
    rating        INT  NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comments      TEXT,
    feedback_date DATE NOT NULL,
    CONSTRAINT fk_fb_user  FOREIGN KEY (user_id)  REFERENCES users(user_id),
    CONSTRAINT fk_fb_event FOREIGN KEY (event_id) REFERENCES events(event_id)
);

-- ---------------------------------------------------------------------
-- 6. Resources
-- ---------------------------------------------------------------------
CREATE TABLE resources (
    resource_id   INT          PRIMARY KEY AUTO_INCREMENT,
    event_id      INT          NOT NULL,
    resource_type ENUM('pdf','image','link') NOT NULL,
    resource_url  VARCHAR(255) NOT NULL,
    uploaded_at   DATETIME     NOT NULL,
    CONSTRAINT fk_res_event FOREIGN KEY (event_id) REFERENCES events(event_id)
);
