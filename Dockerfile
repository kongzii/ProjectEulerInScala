FROM ubuntu:20.04

RUN apt-get update \
    && apt-get upgrade -y

RUN apt-get install -y curl

RUN cd /root \
    && curl -Lo cs https://git.io/coursier-cli-linux \
    && chmod +x cs \
    && ./cs setup --yes

COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

WORKDIR /app

ENTRYPOINT ["/entrypoint.sh"]
