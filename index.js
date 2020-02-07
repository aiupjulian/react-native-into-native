import React from 'react';
import {AppRegistry, StyleSheet, Text, View} from 'react-native';

class RNTestScreen extends React.Component {
  render() {
    var contents = this.props['list'].map((score) => (
      <Text key={score.name}>
        {score.name}: {score.value}
        {'\n'}
      </Text>
    ));
    return (
      <View style={styles.container}>
        <Text style={styles.title}>RN view in native app!</Text>
        <Text style={styles.list}>{contents}</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#FFFFFF',
  },
  title: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  list: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

// Module name
AppRegistry.registerComponent('RNTestScreen', () => RNTestScreen);
