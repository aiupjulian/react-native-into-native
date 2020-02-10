import React from 'react';
import {AppRegistry, StyleSheet, Text, View} from 'react-native';

class RNTestScreen extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.title}>RN view in native app!</Text>
        <Text style={styles.parameter}>{this.props.nativeParameter}</Text>
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
  parameter: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

// Module name
AppRegistry.registerComponent('RNTestScreen', () => RNTestScreen);
