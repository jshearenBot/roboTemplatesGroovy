all:
	hub
	node

hub:
	selenium-standalone start -- -role hub -hubConfig ./gridConfig/hub.json

node:
	selenium-standalone start -- -role node -hub http://localhost:4444/grid/register -nodeConfig ./gridConfig/node.json

macDeps:
	brew install gradle geckodriver chromedriver phantomjs
	npm install selenium-standalone@latest -g
	npm install -g newman
	selenium-standalone install

linuxDeps:
	sudo apt-get install libxss1 libappindicator1 libindicator7
	wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
	sudo dpkg -i google-chrome*.deb
	sudo apt-get install -f
	sudo apt-get install xvfb
	sudo apt-get install unzip
	wget -N http://chromedriver.storage.googleapis.com/2.26/chromedriver_linux64.zip
	unzip chromedriver_linux64.zip
	chmod +x chromedriver
	sudo mv -f chromedriver /usr/local/share/chromedriver
	sudo ln -s /usr/local/share/chromedriver /usr/local/bin/chromedriver
	sudo ln -s /usr/local/share/chromedriver /usr/bin/chromedriver



