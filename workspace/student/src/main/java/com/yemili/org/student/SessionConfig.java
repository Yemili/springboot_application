package com.yemili.org.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.session.config.SessionRepositoryCustomizer;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configurable
@EnableJdbcHttpSession(tableName = "SPRING_SESSION")
public class SessionConfig {
  
	@Bean
    public TableNameCustomizer tableNameCustomizer() {
        return new TableNameCustomizer();
    }
	public class TableNameCustomizer
    implements SessionRepositoryCustomizer<JdbcIndexedSessionRepository> {

@Override
public void customize(JdbcIndexedSessionRepository sessionRepository) {
    sessionRepository.setTableName("SPRING_SESSION");
}

}


}