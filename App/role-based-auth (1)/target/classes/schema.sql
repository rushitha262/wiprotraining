CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  role VARCHAR(20) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- You can pre-create an admin manually by inserting a BCrypt hash into password_hash.
-- Example (hash for "admin123" may differ): 
-- INSERT INTO users (username, password_hash, role) VALUES ('admin', '$2a$10$exampleexampleexampleexampleexamp', 'ADMIN');
