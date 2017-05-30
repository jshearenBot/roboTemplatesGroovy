all:
	hub
	node

hub:
	selenium-standalone start -- -role hub -hubConfig ./gridConfig/hub.json

node:
	selenium-standalone start -- -role node -hub http://localhost:4444/grid/register -nodeConfig ./gridConfig/node.json

deps:
	brew install gradle geckodriver chromedriver
	npm install selenium-standalone@latest -g
	npm install -g newman
	selenium-standalone install
