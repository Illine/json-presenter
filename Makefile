export CURRENT_DIR=$(shell pwd)
export MIN_MEMORY=128M
export MAX_MEMORY=256G
export DISABLED_WARNING_OPTS=--add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.desktop/java.awt.font=ALL-UNNAMED --add-opens java.base/java.time=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/java.lang.invoke=ALL-UNNAMED --add-opens java.base/java.time.zone=ALL-UNNAMED --illegal-access=deny
export JVM_SERVER_OPTS=-server -Xms${MIN_MEMORY} -Xmx${MAX_MEMORY}
export JAVA_OPTS=${DISABLED_WARNING_OPTS} ${JVM_SERVER_OPTS}

develop_up:
	@echo "Building a project via 'gradlew'"
	@./gradlew clean assemble

	@echo "Starting the Docker container"
	@docker-compose -f docker-compose-develop.yaml up -d --build

develop_down:
	@echo "Stoping and removing created docker containers"
	@docker-compose -f docker-compose-develop.yaml down -v --rmi local

prod_up:
	@echo "Starting the Docker container"
	@docker-compose up -d --build

prod_down:
	@echo "Stoping and removing created docker containers"
	@docker-compose down -v --rmi local